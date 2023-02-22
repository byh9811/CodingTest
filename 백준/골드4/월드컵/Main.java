package 백준.골드4.월드컵;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 월드컵
 * https://www.acmicpc.net/problem/6987
 *
 * 1. 총 15번의 매치가 발생한다. 2중 반복문을 이용해서 매치 정보를 확정한다.
 * 2. 각 매치의 승무패팀을 확정하고 다음 매치에 대한 재귀를 호출한다.
 * 3. 만약 고르는 중간에 승무패 중 하나라도 주어진 결과를 초과하면 백트래킹 한다.
 * 4. 모든 팀에 대해 주어진 승무패대로 완성이 되면 true, 하나도 안되면 false로 세팅한다.
 * 5. true이면 1, false이면 0으로 출력한다.
 *
 * @author 배용현
 *
 */
public class Main {
	static int[][] result = new int[6][3];		// A~F나라의 최종 승무패 정보
	static int[][] scoreBoard = new int[6][3];		// A~F나라의 현재 승무패 정보
	static int[][] match = new int[15][2];			// 각 경기 정보
	static int able;		// 0: 불가능, 1: 가능

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		setMatch();		// 경기 정보 세팅

		for(int i=0; i<4; i++) {		// 4번의 입력
			able = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean didAllMatch = true;		//
			for(int j=0; j<6; j++) {		// 경기 결과 초기화
				int teamMatchNum = 0;		// 각 팀의 경기 수

				for(int k=0; k<3; k++) {		// 승무패 정보 저장
					result[j][k] = parseInt(st.nextToken());
					teamMatchNum += result[j][k];		// 경기 수 저장
				}

				if(teamMatchNum!=5)		// 경기 수가 5가 안되면
					didAllMatch = false;		// 정상아님
			}

			if(didAllMatch)		// 정상적이면
				doMatch(0);		// 경기 시뮬레이션 진행

			sb.append(able).append(' ');
		}

		System.out.println(sb);
	}

	private static void setMatch() {
		int idx = 0;		// 각 경기의 인덱스 체크용
		for(int j=0; j<6; j++) {		// 각 경기 정보 초기화
			for(int k=j+1; k<6; k++) {
				match[idx][0] = j;		// home 팀
				match[idx++][1] = k;		// away 팀
			}
		}
	}

	private static void doMatch(int depth) {
		if(!isAble())		// 현재 불가능한 상태면
			return;			// 백트래킹

		if(depth==15) {		// 마지막까지 가능한 상태면
			able = 1;		// 표시하고
			return;			// 리턴
		}

		int homeTeam = match[depth][0];		// 홈팀 인덱스
		int awayTeam = match[depth][1];		// 원정팀 인덱스

		// 홈팀 승리
		scoreBoard[homeTeam][0]++;
		scoreBoard[awayTeam][2]++;
		doMatch(depth+1);
		scoreBoard[homeTeam][0]--;
		scoreBoard[awayTeam][2]--;

		// 무승부
		scoreBoard[homeTeam][1]++;
		scoreBoard[awayTeam][1]++;
		doMatch(depth+1);
		scoreBoard[homeTeam][1]--;
		scoreBoard[awayTeam][1]--;

		// 원정 팀 승리
		scoreBoard[homeTeam][2]++;
		scoreBoard[awayTeam][0]++;
		doMatch(depth+1);
		scoreBoard[homeTeam][2]--;
		scoreBoard[awayTeam][0]--;
	}

	private static boolean isAble() {		// 현재까지의 경기 결과가 주어진 결과로 갈 가능성이 존재하는지 확인하는 메서드
		for(int i=0; i<6; i++) {		// 6x3의 각 결과 중
			for(int j=0; j<3; j++) {
				if(scoreBoard[i][j]>result[i][j])		// 하나라도 주어진 결과를 넘어간다면
					return false;		// 불가능
			}
		}

		return true;		// 아직 하나도 안넘어갔다면 가능
	}
}