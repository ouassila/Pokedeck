/**
 * Classe qui permet de stocker le pokedeck dans un fichier texte
 * Il permet de lire et d'écrire dans un fichier texte donné
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSerialize {

	// déclarations des flux d'entrée et sorties
	private FileInputStream FIS;
	private ObjectInputStream OIS;
	private FileOutputStream FOS;
	private ObjectOutputStream OOS;
	private String nameFile;
	private File file;

	
	public DataSerialize(String name) {
		this.nameFile = name;
		file = new File(name);
	}

	
	public boolean createAndOpen() throws IOException {

		if (!file.exists()) {
			file.createNewFile();
			return true;
		}
		FIS = new FileInputStream(this.nameFile);
		return false;
	}


	public boolean readFile() throws IOException, ClassNotFoundException {

		if (FIS.available() != 0) {
			OIS = new ObjectInputStream(FIS);
			return true;
		}
		return false;
	}
	
	public Pokedeck readPokedeck() throws ClassNotFoundException, IOException {
		return (Pokedeck) OIS.readObject();
	}

	
	public void writeFile(Pokedeck pokedeck) throws IOException {
		FOS = new FileOutputStream(this.nameFile);
		OOS = new ObjectOutputStream(FOS);
		OOS.writeObject(pokedeck);
		OOS.flush();
		OOS.close();
	}

	public void closeIS() throws IOException {
		FIS.close();
		OIS.close();
	}
}
