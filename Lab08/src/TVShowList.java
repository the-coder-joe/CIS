import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ch06.lists.RefSortedList;

public class TVShowList extends RefSortedList<TVShow> {
    public TVShowList() {
        super();
    }

    public int fromFile(String fileName) {
        File file = new File(fileName);
        Scanner inputFile;
        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return 0;
        }

        // eat the first header line
        inputFile.nextLine();

        int count = 0;
        while (inputFile.hasNext()) {
            this.add(new TVShow(inputFile.nextLine()));
            count++;
        }

        inputFile.close();
        return count;
    }

    public TVShowList findNameList(String name) {
        TVShowList list = new TVShowList();
        this.reset();
        int numElements = this.numElements;

        for (int i = 0; i < numElements; i++) {
            TVShow currentShow = this.getNext();
            if (currentShow.getName().contains(name)) {
                list.add(currentShow);
            }
        }

        return list;
    }

    public TVShowList findNameList(String name, int minEpisodes) {
        TVShowList list = new TVShowList();
        this.reset();
        int numElements = this.size();

        for (int i = 0; i < numElements; i++) {
            TVShow currentShow = this.getNext();
            if (currentShow.getName().contains(name) && currentShow.getnEpisodes() >= minEpisodes) {
                list.add(currentShow);
            }
        }

        return list;
    }
}
