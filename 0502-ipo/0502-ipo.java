class Solution {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		List<Project> projects = new ArrayList<>();
		for (int i = 0; i < profits.length; i++) {
			projects.add(new Project(profits[i], capital[i]));
		}

		Collections.sort(projects);

        if (projects.get(0).capital > w) {
			return 0;
		}

        // 이익 기준 최대 힙
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int index = 0;
        for (int i = 0; i < k; i++) {
            // 현재 자본으로 시작할 수 있는 모든 프로젝트를 힙에 추가
            while (index < projects.size() && projects.get(index).capital <= w) {
                maxHeap.offer(projects.get(index));
                index++;
            }

            // 시작할 수 있는 프로젝트가 없다면 종료
            if (maxHeap.isEmpty()) break;

            // 가장 이익이 큰 프로젝트를 수행
            w += maxHeap.poll().profit;
        }
        
		return w;
	}

	class Project implements Comparable<Project> {

		private int profit; // 프로젝트 끝난 후 이익
		private int capital; // 프로젝트를 하기 위해 필요한 자본

		public Project(int profit, int capital) {
			this.profit = profit;
			this.capital = capital;
		}

		@Override
		public int compareTo(Project o) {
			if (o.capital == this.capital) { // 필요자본이 동일하다면
				return o.profit - this.profit; // 수익 내림차순
			}
			return this.capital - o.capital; // 필요자본 오름차순
		}
	}
}