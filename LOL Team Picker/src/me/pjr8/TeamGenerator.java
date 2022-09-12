package me.pjr8;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamGenerator { // Below this is the list of current champions available
		public static ArrayList<String> champPool = new ArrayList<String>(Arrays.asList("Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Aphelios", "Ashe", "AurelionSol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Camille", "Cassiopeia", "ChoGath", "Corki", "Darius", "Diana", "DrMundo", "Draven", "Ekko", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heierdinger", "Illaoi", "Irelia", "Ivern", "Janna", "JarvanIV", "Jax", "Jayce", "Jhin", "Jinx", "KaiSa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kayn", "Kennen", "KhaZix", "Kindred", "Kled", "KogMaw", "LeBlanc", "LeeSin", "Leona", "Lillia", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "MasterYi", "MissFortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nocturne", "NunuandWillump", "Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Qiyana", "Quinn", "Rakan", "Rammus", "RekSai", "Rell", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Samira", "Sejuani", "Senna", "Seraphine", "Sett", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Sylas", "Syndra", "TahmKench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "TwistedFate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "VelKoz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xayah", "Xerath", "XinZhao", "Yasuo", "Yone", "Yorick", "Yuumi", "Zac", "Zed", "Ziggs", "Zilean", "Zoe", "Zyra", "RenataGlasc", "Zeri", "Vex", "Akshan", "Gwen", "Viego", "Rell", "Seraphine", "Samira"));
				
		public static void generateRandomTeamData(int champsPerTeam, int games, boolean file) {
			String data = "";
			Random random = new Random();
			
			for (int i = 0 ; i < games ; i++) {
				data += "Game " + (i + 1) + "\n";
				@SuppressWarnings("unchecked")
				ArrayList<String> remainingChampPool = (ArrayList<String>) champPool.clone();
				ArrayList<String> blue = new ArrayList<String>();
				ArrayList<String> red = new ArrayList<String>();
				for (int x = 0 ; x < (champsPerTeam * 2) ; x++) {
					int rolledChampion = random.nextInt(remainingChampPool.size());
					if (x % 2 == 0 || x == 0) {
						blue.add(remainingChampPool.get(rolledChampion));
						remainingChampPool.remove(rolledChampion);
					} else {
						red.add(remainingChampPool.get(rolledChampion));
						remainingChampPool.remove(rolledChampion);
					}
				}
				data += makeReadableChampionsList(blue, "Blue side") + makeReadableChampionsList(red, "Red side") + "\n";
			}
			if (file == true) {
				createDataFile(data);
				return;
			}
			System.out.println(data);
		}
		
		// Tool to change ArrayList into a clean string for the end user to copy & paste.
		public static String makeReadableChampionsList(ArrayList<String> champions, String name) {
			StringBuilder sb = new StringBuilder();
			sb.append(name + ": ");
			for (int i = 0 ; i < champions.size() ; i++) {
				sb.append(champions.get(i) + ", ");
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n");
			return sb.toString();
		}
		
		public static void createDataFile(String data) {
			java.util.Date date = new java.util.Date();
			@SuppressWarnings("deprecation")
			String time = date.getHours() + " " + date.getMinutes() + " " + date.getSeconds();
			try {
				File file = new File("TeamPicker " + time + ".txt");
				if (!file.createNewFile()) {
					System.out.println("File already exists");
				}
				
			} catch (Exception e) {
				System.out.println("Failed to create file.");
				System.out.println(e.getStackTrace());
			}
			
			try {
				FileWriter writer = new FileWriter("TeamPicker " + time + ".txt");
				writer.write(data);
				writer.close();
				System.out.println("Successfully saved to file TeamPicker " + time + ".txt");
			} catch (Exception e) {
				System.out.println("Failed to write to file.");
			}
		}
}
