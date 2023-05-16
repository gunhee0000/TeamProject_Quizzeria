package no.answer.quizzeria;

import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.entity.BoardReply;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.repository.BoardReplyRepository;
import no.answer.quizzeria.repository.BoardRepository;
import no.answer.quizzeria.repository.MemberRepository;
import no.answer.quizzeria.service.BoardService;
import no.answer.quizzeria.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardReplyRepository boardReplyRepository;



    @Test
    public void makeBoardDummy(){
        IntStream.rangeClosed(1,200).forEach(i -> {
            long ranMno = (long)((Math.random() * 30)+1);

            Member member = Member.builder().mno(ranMno).build();

            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .category("Others")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    public void makeBoardCommentsDummy(){
        IntStream.rangeClosed(1,100).forEach(i -> {

            Board board = Board.builder().bno((long)i).build();
            int ranCountOfComment = (int)((Math.random() * 5)+1);

            IntStream.rangeClosed(1, ranCountOfComment).forEach(j -> { //board 하나당 1~5개 댓글
                long ranMNO = (long)((Math.random() * 30)+1);
                Member member = Member.builder().mno(ranMNO).build();
                BoardReply boardReply = BoardReply.builder()
                        .content("Comments..." + j)
                        .member(member)
                        .board(board)
                        .hidden("N")
                        .likes((long)0)
                        .build();
                boardReplyRepository.save(boardReply);
            });
        });
    }

    //원하는 개수만큼 board 가져오기

    @Test
    public void selectBoard(){
        int start = (int)boardRepository.count() - 6;
        int end = (int)boardRepository.count();

        ArrayList<Board> boardlist = new ArrayList<>();

        IntStream.rangeClosed(start, end).forEach(i -> {

            Optional<Board> result = boardRepository.findById((long)i);
            Board board = result.get();
            boardlist.add(board);

        });

        System.out.println("////////////////////////////" + boardlist);
    }
}
