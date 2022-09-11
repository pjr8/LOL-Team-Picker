package me.pjr8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamGenerator { //Below this is the list of current champions available
		public static ArrayList<String> champPool = new ArrayList<String>(Arrays.asList("Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Aphelios", "Ashe", "AurelionSol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Camille", "Cassiopeia", "ChoGath", "Corki", "Darius", "Diana", "DrMundo", "Draven", "Ekko", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heierdinger", "Illaoi", "Irelia", "Ivern", "Janna", "JarvanIV", "Jax", "Jayce", "Jhin", "Jinx", "KaiSa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kayn", "Kennen", "KhaZix", "Kindred", "Kled", "KogMaw", "LeBlanc", "LeeSin", "Leona", "Lillia", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "MasterYi", "MissFortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nocturne", "NunuandWillump", "Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Qiyana", "Quinn", "Rakan", "Rammus", "RekSai", "Rell", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Samira", "Sejuani", "Senna", "Seraphine", "Sett", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Sylas", "Syndra", "TahmKench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "TwistedFate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "VelKoz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xayah", "Xerath", "XinZhao", "Yasuo", "Yone", "Yorick", "Yuumi", "Zac", "Zed", "Ziggs", "Zilean", "Zoe", "Zyra", "RenataGlasc", "Zeri", "Vex", "Akshan", "Gwen", "Viego", "Rell", "Seraphine", "Samira"));
		
		private static int champsPerTeam = 11; // # of champions per team (+1, so in the case of 11 it's 12 champions per team)
		
		public static void generateRandomTeam() {
			ArrayList<String> remainingChampPool = champPool;
			ArrayList<String> blue = new ArrayList<String>();
			ArrayList<String> red = new ArrayList<String>();
			Random random = new Random();
			
			// Alternate between teams to give random non-duplicate champions, starting with blue side.
			
			for (int i = 0 ; i < (champsPerTeam * 2) ; i++) {
				int rolledChampion = random.nextInt(remainingChampPool.size());
				if (i % 2 == 0 || i == 0) {
					blue.add(remainingChampPool.get(rolledChampion));
					remainingChampPool.remove(rolledChampion);
				} else {
					red.add(remainingChampPool.get(rolledChampion));
					remainingChampPool.remove(rolledChampion);
				}
			}
			
			//To make more readable, make it in commas w/o brackets in display text
			
			System.out.println("Blue team: " + makeReadableChampionsList(blue));
			System.out.println("Red team: " + makeReadableChampionsList(red));
		}
		
		// Tool to change ArrayList into a clean string for the end user to copy & paste.
		public static String makeReadableChampionsList(ArrayList<String> champions) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0 ; i < champions.size() ; i++) {
				sb.append(champions.get(i) + ", ");
			}
			sb.setLength(sb.length() - 2);
			return sb.toString();
		}
}
