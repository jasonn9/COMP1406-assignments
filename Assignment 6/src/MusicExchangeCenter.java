import javafx.util.Pair;
import java.util.*;

public class MusicExchangeCenter {
    ArrayList<User> users;
    HashMap<String, Float> royalties;
    ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter () {
        users = new ArrayList<User>();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public User userWithName(String s){
        for (User u: users){
            if (u.getUserName().contains(s)){
                return u;
            }
        }
        return null;
    }

    public void registerUser(User x) {
        //for (User u: users){
        if(userWithName(x.getUserName()) == null){
            users.add(x);
        }
        //}
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> usersOnline = new ArrayList<User>();
        for (User u: users){
            if (u.isOnline()){
                usersOnline.add(u);
            }
        }
        return usersOnline;
    }

    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongs = new ArrayList<Song>();
        for (User u: onlineUsers()){
            for (Song s : u.getSongList()){
                availableSongs.add(s);
            }
        }
        return availableSongs;
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> songsByArtist = new ArrayList<Song>();
        for (Song s: allAvailableSongs()){
            if (s.getArtist().equals(artist)){
                songsByArtist.add(s);
            }
        }
        return songsByArtist;
    }

    public Song getSong(String title, String ownerName){
        for (User u: onlineUsers()){
            if (userWithName(ownerName) != null){
                for (Song s: u.getSongList()){
                    if (u.songWithTitle(title) != null){
                        downloadedSongs.add(s);
                        int d = s.getDownloads();
                        d++;
                        s.setDownloads(d);
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public void displayRoyalties() {
        for (Song s: downloadedSongs){
            for (int i = 0; i < s.getDownloads(); i++){
                //if
            }

        }

    }

    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> uniqueSongs = new TreeSet<>(downloadedSongs);

        return uniqueSongs;
    }

    public Pair<Integer, Song> songsByPopularity() {
        //Pair<Integer, Song> popularSongs = new Pair<Integer, Song>();

       // Collections.sort(popular, new Comparator<Pair<Integer, Song>>() {

        //})
        return null;
    }


    public String toString() {
        String s = "Music Exchange Center (" + onlineUsers().size() + " users on line, " + allAvailableSongs().size() + " songs available)";
        return s;
    }


}
