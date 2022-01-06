package com.sbrf.reboot;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Long> getAllAccountsByClientId(long clientId) throws IOException;
}
