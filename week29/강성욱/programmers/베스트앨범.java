package week29.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * PackageName : week29.강성욱.programmers
 * FileName    : 베스트앨범
 * Author      : Baekgwa
 * Date        : 25. 11. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 21.     Baekgwa               Initial creation
 */
public class 베스트앨범 {
	// 장르별로, 많은걸 찾아야함.
	// 장르별, 노래 정보를 top2 가져올 수 있어야함.

	class Solution {
		public int[] solution(String[] genres, int[] plays) {

			Map<String, Integer> genreTotal = new HashMap<>(); //key : 장르, value : 횟수
			Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>(); //key : 장르, value : 노래 정보

			for (int id = 0; id < genres.length; id++) {
				String genre = genres[id];
				int play = plays[id];

				genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);

				genreSongs.putIfAbsent(genre, new PriorityQueue<>((a, b) -> b.plays - a.plays));
				genreSongs.get(genre).offer(new Song(genre, id, play));
			}

			// 장르별 순서 확인
			List<String> order = new ArrayList<>(genreTotal.keySet());
			order.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

			List<Integer> resultList = new ArrayList<>();

			for (String genre : order) {
				PriorityQueue<Song> pq = genreSongs.get(genre);

				int cnt = 0;
				//최대 2곡 넣음
				for(int i=0; i<2; i++) {
					if(pq.isEmpty()) break; //비어있으면 못넣음
					resultList.add(pq.poll().id);
				}
			}

			return resultList.stream().mapToInt(i -> i).toArray();
		}

		private class Song {
			private String genre;
			private int id;
			private int plays;

			public Song(String genre, int id, int plays) {
				this.genre = genre;
				this.id = id;
				this.plays = plays;
			}
		}
	}
}
