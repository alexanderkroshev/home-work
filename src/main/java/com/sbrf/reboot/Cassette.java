package com.sbrf.reboot;

import java.util.ArrayList;
import java.util.List;

public class Cassette<T> {

    private List<T> banknotes;

    public Cassette(ArrayList<T> banknotes) {
        this.banknotes = banknotes;
    }

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
