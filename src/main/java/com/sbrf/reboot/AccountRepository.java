package com.sbrf.reboot;

import java.util.Set;

public interface AccountRepository {

     Set<Long> getAllAccountsByClientId(long clientId);

}
