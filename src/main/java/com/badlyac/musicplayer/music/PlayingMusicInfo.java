package com.badlyac.musicplayer.music;

public class PlayingMusicInfo {

    public final long startTime;
    public final IMusicDisc disc;

    public PlayingMusicInfo(long startTime, IMusicDisc disc) {
        this.startTime = startTime;
        this.disc = disc;
    }
}
