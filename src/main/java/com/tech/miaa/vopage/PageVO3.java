package com.tech.miaa.vopage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageVO3 {
	private Integer displayRowCount = 5; // 출력할 데이터 개수
	private Integer grpPageCnt = 10; //// 페이지그룹에서 페이지갯수 수정*
	private Integer rowStart; // 시작행번호
	private Integer rowEnd; // 종료행 번호
	private Integer totPage; // 전체 페이수
	private Integer totRow = 0; // 전체 데이터 수
	private Integer page; // 현재 페이지
	private Integer pageStart; // 시작페이지
	private Integer pageEnd; // 종료페이지

	/**
	 * 전체 데이터 개수(total)를 이용하여 페이지수 계산.
	 */
	public void pageCalculate(Integer total) {
		getPage();
		totRow = total;
		totPage = (int) (total / displayRowCount);

		if (total % displayRowCount > 0) {
			totPage++;
		}

		pageStart = (page - (page - 1) % grpPageCnt);
		pageEnd = pageStart + (grpPageCnt - 1);
		if (pageEnd > totPage) {
			pageEnd = totPage;
		}
		if (page == null || page == 0 || page < 0) {
			page = 1;
		} //totalPage 가  0인경우 page가 0 이되어 rowStrat가 음수값이 나오는 문제처리 /0425 김영빈 추가
		else if (page > pageEnd && totPage>=1) {
			page = pageEnd;
		}

		rowStart = ((page - 1) * displayRowCount) + 1;
		rowEnd = rowStart + displayRowCount - 1;
	}

	/**
	 * 현재 페이지 번호.
	 */
	public Integer getPage() {
		if (page == null || page == 0 || page < 0) {
			page = 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRowStart() {
		return rowStart;
	}

	public void setRowStart(Integer rowStart) {
		this.rowStart = rowStart;
	}

	public Integer getRowEnd() {
		return rowEnd;
	}

	public void setRowEnd(Integer rowEnd) {
		this.rowEnd = rowEnd;
	}

	public Integer getDisplayRowCount() {
		return displayRowCount;
	}

	public void setDisplayRowCount(Integer displayRowCount) {
		this.displayRowCount = displayRowCount;
	}

	public Integer getTotPage() {
		return totPage;
	}

	public void setTotPage(Integer totPage) {
		this.totPage = totPage;
	}

	public Integer getTotRow() {
		return totRow;
	}

	public void setTotRow(Integer totRow) {
		this.totRow = totRow;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}

	public void setNextPage() {
		page++;
	}

}
