package com.web.board.dto;

import java.sql.Date;
import java.util.List;

import com.web.member.model.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
//	"BOARD_NO" NUMBER, 
//	"BOARD_TITLE" VARCHAR2(50), 
//	"BOARD_WRITER" VARCHAR2(15), 
//	"BOARD_CONTENT" VARCHAR2(2000), 
//	"BOARD_ORIGINAL_FILENAME" VARCHAR2(100), 
//	"BOARD_RENAMED_FILENAME" VARCHAR2(100), 
//	"BOARD_DATE" DATE DEFAULT SYSDATE, 
//	"BOARD_READCOUNT" NUMBER DEFAULT 0, 
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenamedFileName;
	private Date boardDate;
	private int boardReadConut;
	private Member member;
	private List<BoardComment> comments;

}
