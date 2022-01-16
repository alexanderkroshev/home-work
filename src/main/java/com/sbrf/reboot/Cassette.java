package com.sbrf.reboot;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class Cassette<T extends Banknote> {

    private final List<T> banknotes;

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
