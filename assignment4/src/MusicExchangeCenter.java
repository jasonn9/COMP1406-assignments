import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class MusicExchangeCenter {
    ArrayList<User> users;
    HashMap<String, Float> royalties;
    ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter(){
        users = new ArrayList<>();
        royalties = new HashMap<String,Float>();
        downloadedSongs = new ArrayList<Song>();

    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> online = new ArrayList<>();
        for (User u: users){
            if (u.isOnline()){
                online.add(u);
            }
        }
        return online;
    }

    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongs = new ArrayList<>();
        for (User u: onlineUsers()){
            for (Song s: u.getSongList()){
                availableSongs.add(s);
            }
        }
        return availableSongs;
    }

    public String toString(){
        return "Music Exchange Center (" + onlineUsers().size() + " users online, "
                + allAvailableSongs().size() + " songs available)";
    }

    public User userWithName(String s){
        for (User u: users){
            if (u.getUserName().equals(s)){
                return u;
            }
        }
        return null;
    }

    public void registerUser(User x){
        if (userWithName(x.getUserName()) == null){
            users.add(x); }
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> songsByArtist = new ArrayList<Song>();
        for (Song s: allAvailableSongs()){
            if (s.getArtist() == artist){
                songsByArtist.add(s);
            }
        }
        return songsByArtist;
    }

    public Song getSong(String title, String ownerName){
        for (User u: users){
            if (userWithName(ownerName) != null){
                for (Song s: u.getSongList()){
                    if (u.songWithTitle(title) != null){
                        downloadedSongs.add(s);
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public void displayRoyalties(){
        //ArrayList<String> royaltiesPrint = new ArrayList<>();
        String titles = String.format("%10s %10s", "Amount", "Artist");
        System.out.println(titles);
        String lines = "------------------------";
        System.out.println(lines);
        for (Song s: downloadedSongs){
            if(royalties.containsKey(s.getArtist())){
                royalties.put(s.getArtist(), royalties.get(s.getArtist()) + 0.25f);
            }
            if(!royalties.containsKey(s.getArtist())){
                royalties.put(s.getArtist(), 0.25f);
            }
        }

        for (String s: royalties.keySet()){
            String royals = String.format("%-1s %.2f %5s %10s", "$", royalties.get(s)," ", s);
            System.out.println(royals);
        }

    }

    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> uniqueSongs = new TreeSet<Song>(downloadedSongs);
        for (Song s: downloadedSongs){
            if (!uniqueSongs.contains(s)){
                uniqueSongs.add(s);
            }
        }
        return uniqueSongs;
    }

    //public ArrayList<Integer,Song> songsByPopularity(){

    //}
}
