package com.github.echokilosierra.intel.login;


import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

abstract class EncryptUserData 
{

    private static transient KeyPairGenerator keyPairGen;
    private static transient KeyPair pair;

    //Generates KeyPair to be accessed by the Encryption/Decryption Process
    private final void genKey() throws NoSuchAlgorithmException
    {
        keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        pair = keyPairGen.generateKeyPair();
    }

    //Calls Encryption Process on input and returns the encrypted byte[]
    protected final byte[] encrypt(byte[] input)
    {
        try {
            return processEncryption(true, input);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Calls Decryption Process on the inpit and return the decrypted byte[]
    protected final byte[] decrypt(byte[] input)
    {
        try {
            return processEncryption(false, input);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static transient Cipher cipher;
    private static transient byte[] cipherText;
    private static transient byte[] decipheredText;
    private static transient PublicKey  publicKey;
    private static transient PrivateKey privateKey;
    //Encryption/Decryption Process using RSA Encryption on the byte[]
    private final byte[] processEncryption(boolean encrypt, byte[] input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        if(encrypt == true){
            genKey();
        }
        publicKey  = pair.getPublic();
        privateKey = pair.getPrivate();
        if(encrypt == true) {
            cipher     = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipher.update(input);
            cipherText = cipher.doFinal();
            return cipherText;
        }
        else if (encrypt == false) {
            cipher         = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            cipher.update(input);
            decipheredText = cipher.doFinal();
            return decipheredText;
        } else {
                return null;
        }
    }
}
