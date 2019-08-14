import java.util.ArrayList;

public class User {
    private String userName;
    private boolean online;
    private ArrayList<Song> songList;

    public User() {
        this("");
    }

    public User(String u) {
        userName = u;
        online = false;
        songList = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public boolean isOnline() {
        return online;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public String toString() {
        String s = "" + userName + ": " + getSongList().size() + " songs (";
        if (!online) s += "not ";
        return s + "online)";
    }

    public void addSong(Song s){
        songList.add(s);
        s.setOwner(this);
    }

    public int totalSongTime(){
        int x = 0;
        for(Song s: songList){
            x += s.getDuration();
        }
        return x;
    }

    public void register(MusicExchangeCenter m){ m.registerUser(this);}

    public void logon(MusicExchangeCenter m){
       if(m.userWithName(this.getUserName()) != null) {
           this.online = true;
       }
    }

    public void logoff(MusicExchangeCenter m) {
        if (m.userWithName(this.getUserName()) != null) {
            this.online = false;
        }
    }

    public Song songWithTitle(String s){
        for (Song song: songList){
            if (song.getTitle().equals(s)){
                return song;
            }
        }
        return null;
    }

    public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
        ArrayList<String> completeSonglist = new ArrayList<>();
        String format = String.format("%4s %-50s %-30s %-10s %-10s "," ","TITLE", "ARTIST", "TIME", "OWNER");
        completeSonglist.add(format);
        int numbered = 0;
        String dot = ".";

        for (Song s: m.allAvailableSongs()){
            numbered++;
            String songs = String.format("%2d %-1s %-50s %-30s %-1d %-1s %-5d %-30s", numbered, dot, s.getTitle(), s.getArtist(), s.getMinutes(), ":", s.getSeconds(), s.getOwner().getUserName());
            completeSonglist.add(songs);
        }
        return completeSonglist;
    }

    public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
        ArrayList<String> songlistByArtist = new ArrayList<>();
        String format = String.format("%4s %-50s %-30s %-10s %-10s "," ","TITLE", "ARTIST", "TIME", "OWNER");
        songlistByArtist.add(format);
        int numbered = 0;
        String dot = ".";

        for (Song s: m.allAvailableSongs()){
            if (s.getArtist().equals(artist)){
                numbered++;
                String songs = String.format("%-2d %-1s %-50s %-30s %-1d %-1s %-5d %-30s", numbered, dot, s.getTitle(), s.getArtist(), s.getMinutes(), ":", s.getSeconds(), s.getOwner().getUserName());
                songlistByArtist.add(songs);
            }
        }
        return songlistByArtist;
    }

    public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
        if (m.getSong(title, ownerName) != null){
            songList.add(m.getSong(title, ownerName));
        }
    }

    // Various Users for test purposes
    public static User DiscoStew() {
        User  discoStew = new User("Disco Stew");
        discoStew.addSong(new Song("Hey Jude", "The Beatles", 4, 35));
        discoStew.addSong(new Song("Barbie Girl", "Aqua", 3, 54));
        discoStew.addSong(new Song("Only You Can Rock Me", "UFO", 4, 59));
        discoStew.addSong(new Song("Paper Soup Cats", "Jaw", 4, 18));
        return discoStew;
    }

    public static User SleepingSam() {
        User sleepingSam = new User("Sleeping Sam");
        sleepingSam.addSong(new Song("Meadows", "Sleepfest", 7, 15));
        sleepingSam.addSong(new Song("Calm is Good", "Waterfall", 6, 22));
        return sleepingSam;
    }

    public static User RonnieRocker() {
        User ronnieRocker = new User("Ronnie Rocker");
        ronnieRocker.addSong(new Song("Rock is Cool", "Yeah", 4, 17));
        ronnieRocker.addSong(new Song("My Girl is Mean to Me", "Can't Stand Up", 3, 29));
        ronnieRocker.addSong(new Song("Only You Can Rock Me", "UFO", 4, 52));
        ronnieRocker.addSong(new Song("We're Not Gonna Take It", "Twisted Sister", 3, 9));
        return ronnieRocker;
    }

    public static User CountryCandy() {
        User countryCandy = new User("Country Candy");
        countryCandy.addSong(new Song("If I Had a Hammer", "Long Road", 4, 15));
        countryCandy.addSong(new Song("My Man is a 4x4 Driver", "Ms. Lonely", 3, 7));
        countryCandy.addSong(new Song("This Song is for Johnny", "Lone Wolf", 4, 22));
        return countryCandy;
    }

    public static User PeterPunk() {
        User peterPunk = new User("Peter Punk");
        peterPunk.addSong(new Song("Bite My Arms Off", "Jaw", 4, 12));
        peterPunk.addSong(new Song("Where's My Sweater", "The Knitters", 3, 41));
        peterPunk.addSong(new Song("Is that My Toenail ?", "Clip", 4, 47));
        peterPunk.addSong(new Song("Anvil Headache", "Clip", 4, 34));
        peterPunk.addSong(new Song("My Hair is on Fire", "Jaw", 3, 55));
        return peterPunk;
    }
}