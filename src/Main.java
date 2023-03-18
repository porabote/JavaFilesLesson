import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        createDirectories();
        createSaveArchives();
    }

    static void createDirectories() throws IOException {

        try {

            Files.setRoot("Games/");

            Files.makeDirectory("src");

            Files.makeDirectory("res");
            Files.makeDirectory("res/drawables");
            Files.makeDirectory("res/vectors");
            Files.makeDirectory("res/icons");

            Files.makeDirectory("savegames");

            Files.makeDirectory("temp");
            File tmpFile = Files.makeFile("temp/temp.txt");

            Files.makeDirectory("src/main");
            Files.makeFile("src/main/Main.java");
            Files.makeFile("src/main/Utils.java");

            Files.makeDirectory("src/test");


            Files.write("temp/temp.txt", Logger.get());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void createSaveArchives() {

        String savePath = "Games/savegames/";

        GameProgress state1 = new GameProgress(5, 3, 7, 8);
        state1.saveGame(savePath + "save1.dat", state1);

        GameProgress state2 = new GameProgress(1, 2, 3, 6);
        state2.saveGame(savePath + "save2.dat", state2);

        GameProgress state3 = new GameProgress(9, 4, 6, 7);
        state3.saveGame(savePath + "save3.dat", state3);

        Files.zipFiles(
                savePath + "archive.zip",
                new String[] {
                        savePath + "save1.dat",
                        savePath + "save2.dat",
                        savePath + "save3.dat"
                }
                );

    }

}