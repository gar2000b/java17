package com.onlineinteract.uml;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class RSAKeyGenerator {

    public static void main(String[] args) {
        int keySize = 128; // Example: Use 2048 or 4096
        RSAKeyGenerator rsa = new RSAKeyGenerator();

        // Generate primes and compute n, φ(n)
        BigInteger[] primes = rsa.generatePrimes(keySize);
        BigInteger n = primes[0].multiply(primes[1]); // Modulus n
        BigInteger phi = rsa.computePhi(primes[0], primes[1]); // φ(n)

        // Generate public and private keys
        BigInteger[] publicKey = rsa.generatePublicKey(n);
        BigInteger privateKeyD = rsa.generatePrivateKey(publicKey[0], phi); // Private exponent d

        System.out.println("Public Key: " + publicKey[0]);
        System.out.println("Private Key: " + privateKeyD);

        // Encrypt a message using the public key
        String message = "Hello World";
        BigInteger encryptedMessage = rsa.encryptMessage(message, publicKey[0], publicKey[1]);

        // Print the encrypted message
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message using the private key
        String decryptedMessage = rsa.decryptMessage(encryptedMessage, privateKeyD, publicKey[1]);

        // Print the decrypted message
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    // Method to generate two large prime numbers: returns [p, q]
    public BigInteger[] generatePrimes(int keySize) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(keySize / 2, random);
        BigInteger q = BigInteger.probablePrime(keySize / 2, random);
        return new BigInteger[]{p, q};
    }

    // Method to compute φ(n) = (p - 1) * (q - 1)
    public BigInteger computePhi(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    }

    // Method to generate the public key: returns [e, n]
    public BigInteger[] generatePublicKey(BigInteger n) {
        BigInteger e = BigInteger.valueOf(65537); // Common public exponent
        return new BigInteger[]{e, n}; // Public key as [e, n]
    }

    // Method to generate the private key: d = e^(-1) mod φ(n)
    public BigInteger generatePrivateKey(BigInteger e, BigInteger phi) {
        return e.modInverse(phi); // Private exponent d
    }

    // Method to encrypt a message using the public key (e, n)
    public BigInteger encryptMessage(String message, BigInteger e, BigInteger n) {
        BigInteger messageAsInt = new BigInteger(message.getBytes(StandardCharsets.UTF_8));
        return messageAsInt.modPow(e, n); // C = M^e mod n
    }

    // Method to decrypt a message using the private key (d, n)
    public String decryptMessage(BigInteger encryptedMessage, BigInteger d, BigInteger n) {
        BigInteger decryptedMessageAsInt = encryptedMessage.modPow(d, n); // M = C^d mod n
        return new String(decryptedMessageAsInt.toByteArray(), StandardCharsets.UTF_8);
    }
}
