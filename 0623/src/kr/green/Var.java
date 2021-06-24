package kr.green;

public class Var {
		private int priVar = 1;
		int defVar = 2;
		protected int proVar = 3;
		public int pubVar = 4;

		public void show() {
			System.out.println("private    : " + priVar);
			System.out.println("defVar     : " + defVar);
			System.out.println("proVar     : " + proVar);
			System.out.println("pubVar     : " + pubVar);
		}
	}


