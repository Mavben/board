package com.example.boardar.dao;

/*
    N+1 문제

    실무에서 eager loading은 사용하면 안됨
    가급적 지연 로딩만 사용(특히 실무에서)
    즉시 로딩을 적용하면 예상하지 못한 SQL이 발생
    즉시 로딩은 JPQL에서 N + 1 문제를 일으킨다.
    @ManyToOne, @OneToOne은 기본이 즉시 로딩 ➔ LAZY로 설정
    @OneToMany, @ManyToMany는 기본이 지연 로딩

     ** https://www.inflearn.com/questions/292023/n-1-select-%EB%AC%B8%EC%A0%9C
        https://youtu.be/rYj8PLIE6-k?si=RNj4I_1uFktn6Ph_
 */


import com.example.boardar.dto.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsertOperations insertBoard;

    // 생성자 주입. 스프링이 자동으로 HikariCP Bean을 주입한다.
    public BoardDao(DataSource dataSource){
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        insertBoard = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("board_id"); // 자동으로 증가되는 id를 설정.
    }

    @Transactional
    public void addBoard(int userId, String title, String content) {
        Board board = new Board();
        board.setUserId(userId);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(LocalDateTime.now());
        SqlParameterSource params =  new BeanPropertySqlParameterSource(board);
        insertBoard.execute(params);
    }

    @Transactional(readOnly = true)
    public int getTotalCount() {
        String sql = "select count(*) as total_count from board"; // 무조건 1건의 데이터가 나온다.
        Integer totalCount = jdbcTemplate.queryForObject(sql, Map.of(), Integer.class);
        return totalCount.intValue();
    }

    @Transactional(readOnly = true)
    public List<Board> getBoards(int page) {
        // start는 0, 10, 20, 30 는 1page, 2page, 3page, 4page
        int start = (page - 1) * 10;
        String sql = "select b.user_id, b.board_id, b.title, b.regdate, b.view_cnt, u.name from board b, user u where b.user_id = u.user_id  order by board_id desc limit :start, 10";
        RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
        List<Board> list = jdbcTemplate.query(sql, Map.of("start", start), rowMapper);
        return list;
    }

    @Transactional(readOnly = true)
    public Board getBoard(int boardId) {
        // 1건 또는 0건.
        String sql = "select b.user_id, b.board_id, b.title, b.regdate, b.view_cnt, u.name, b.content from board b, user u where b.user_id = u.user_id  and b.board_id = :boardId";
        RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
        Board board = jdbcTemplate.queryForObject(sql, Map.of("boardId", boardId), rowMapper);
        return board;
    }

    @Transactional
    public void updateViewCnt(int boardId) {
        String sql = "update board\n" +
                "set view_cnt = view_cnt + 1\n" +
                "where board_id = :boardId";
        jdbcTemplate.update(sql, Map.of("boardId", boardId));
    }

    @Transactional
    public void deleteBoard(int boardId) {
        String sql = "delete from board where board_id = :boardId";
        jdbcTemplate.update(sql, Map.of("boardId", boardId));
    }

    @Transactional
    public void updateBoard(int boardId, String title, String content) {
        String sql = "update board\n" +
                "set title = :title , content = :content\n" +
                "where board_id = :boardId";
        Board board = new Board();
        board.setBoardId(boardId);
        board.setTitle(title);
        board.setContent(content);
        SqlParameterSource params =  new BeanPropertySqlParameterSource(board);
        jdbcTemplate.update(sql, params);
//        jdbcTemplate.update(sql, Map.of("boardId", boardId, "title", title, "content", content));
    }
}