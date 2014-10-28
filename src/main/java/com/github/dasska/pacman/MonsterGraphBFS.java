package com.github.dasska.pacman;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MonsterGraphBFS extends Monster {

	public MonsterGraphBFS(int sleep, Point point, Game game) {
		super(sleep, point, game, Color.GREEN);
	}

	@Override
	public void move() {
        Graph graph = new Graph();
        graph.bfs(point);
        point = new Point(graph.pathBack(game.getPacman().getPoint()));
	}


    private class Graph {
        private Map<Point, Point> visited;

        public Graph() {
            visited = new HashMap<Point, Point>();
        }

        public Iterable<Point> adj(Point v) {
            List<Point> list = new LinkedList<Point>();

            if (game.canMoveLeft(v)) {
                Point p = new Point(v);
                p.left(game.getWidth());
                list.add(p);
            }
            if (game.canMoveRight(v)) {
                Point p = new Point(v);
                p.right(game.getWidth());
                list.add(p);
            }
            if (game.canMoveUp(v)) {
                Point p = new Point(v);
                p.up(game.getHeight());
                list.add(p);
            }
            if (game.canMoveDown(v)) {
                Point p = new Point(v);
                p.down(game.getHeight());
                list.add(p);
            }
            return list;
        }

        public Point pathBack(Point packman) {
            Point prev = point;
            while (!packman.equals(point)) {
                Point minPoint = visited.get(packman);

                if (minPoint == null)
                    break;

                prev = packman;
                packman = minPoint;
            }
            return prev;
        }

        public void bfs(Point point) {
            Queue<Pair> queue = new LinkedList<Pair>();
            queue.add(new Pair(point, null));
            bfs(queue);
        }

        private void bfs(Queue<Pair> queue) {
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                visited.put(pair.getPoint(), pair.getFrom());
                
                if (pair.getPoint().equals(game.getPacman()))
                	break;
                
                for(Point p: adj(pair.getPoint())) {
                    if (!visited.containsKey(p))
                        queue.add(new Pair(p, pair.getPoint()));
                }
            }
        }
    }

    private static class Pair {
        private Point point;
        private Point from;

        private Pair(Point point, Point from) {
            this.point = point;
            this.from = from;
        }

        public Point getPoint() {
            return point;
        }

        public Point getFrom() {
            return from;
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((point == null) ? 0 : point.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (point == null) {
				if (other.point != null)
					return false;
			} else if (!point.equals(other.point))
				return false;
			return true;
		}
    }
}

