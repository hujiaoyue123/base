package com.boxin.base.common.security;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordService {
	
	private HashedCredentialsMatcher HashedCredentialsMatcher;

	public HashedCredentialsMatcher getHashedCredentialsMatcher() {
		return HashedCredentialsMatcher;
	}

	public void setHashedCredentialsMatcher(HashedCredentialsMatcher hashedCredentialsMatcher) {
		HashedCredentialsMatcher = hashedCredentialsMatcher;
	}

	public String generate(String username,String password){
		return new SimpleHash(HashedCredentialsMatcher.getHashAlgorithmName(),password,username,HashedCredentialsMatcher.getHashIterations()).toHex();
	}
	
	public static void main(String[] args){
		System.out.println(new SimpleHash("SHA-256","123456", "admin",1024).toHex());
	}

}
