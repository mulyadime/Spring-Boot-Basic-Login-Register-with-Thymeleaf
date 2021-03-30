/**
 * 
 */
package com.mulyadime.lsp.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hamid.mulyadi
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	Account findOneByUsername(String username);
}
