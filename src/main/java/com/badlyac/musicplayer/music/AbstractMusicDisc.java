package com.badlyac.musicplayer.music;

public abstract class AbstractMusicDisc implements IMusicDisc {
    private byte[] sha1;

    public byte[] getSha1() { return sha1; }

    public void setSha1(byte[] sha1) { this.sha1 = sha1; }
}
