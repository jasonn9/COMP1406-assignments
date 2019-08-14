import java.util.ArrayList;

public class User {
    private String     userName;
    private boolean    online;
    private ArrayList<Song> songList;

    public User()  { this(""); }

    public User(String u)  {
        userName = u;
        online = false;
        songList = new ArrayList<>();
    }

    public String getUserName() { return userName; }
    public boolean isOnline() { return online; }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public String toString()  {
        String s = "" + userName + ": " + getSongList().size() + " songs (";
        if (!online) s += "not ";
        return s + "online)";
    }

    public void addSong(Song s){
        songList.add(s);
        s.setOwner(this);
    }

    public int totalSongTime(){
        int songTime = 0;
        for (Song s: songList){
            songTime += s.getDuration();
        }
        return songTime;
    }

    public void register(MusicExchangeCenter m){
        m.registerUser(this);
    }

    public void logon(){
        this.online = true;
    }

    public void logoff(){
        this.online = false;
    }
    public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
        ArrayList<String> completeSonglist = new ArrayList<>();
        String titles = String.format("%4s %-40s %-30s %-15s %-10s "," ","TITLE", "ARTIST", "TIME", "OWNER");
        completeSonglist.add(titles);
        int count = 0;

        for (Song s: m.allAvailableSongs()){
            count++;
            String songs = String.format("%2d %-40s %-30s %-1d %-1s %-10d %-10s",
                    count, s.getTitle(), s.getArtist(), s.getMinutes(), ":", s.getSeconds(),
                    s.getOwner().getUserName());
            completeSonglist.add(songs);
        }
        return completeSonglist;
    }

    public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
        ArrayList<String> songlistByArtist = new ArrayList<>();
        String titles = String.format("%1s %-27s %-15s %-10s %-10s ","    ","TITLE", "ARTIST", "TIME", "OWNER");
        songlistByArtist.add(titles);
        int count = 0;

        for (Song s: m.allAvailableSongs()){
            if (s.getArtist() == artist){
                count++;
                String songs = String.format("%-2d %-30s %-14s %-1d %-1s %-5d %-30s",
                        count, s.getTitle(), s.getArtist(), s.getMinutes(), ":",
                        s.getSeconds(), s.getOwner().getUserName());
                songlistByArtist.add(songs);
            }
        }
        return songlistByArtist;
    }

    public Song songWithTitle(String s){
        for (Song x: songList){
            if (x.getTitle() == s){
                return x;
            }
        }
        return null;
    }

    public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
        if (m.getSong(title, ownerName) != null){
            this.songList.add(m.getSong(title, ownerName));
        }
    }
}

