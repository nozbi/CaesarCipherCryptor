package controller.model;

import controller.model.caesarciphercryptor.CaesarCipherCryptor;

public final class Model 
{
    public Model()
    {

    }

    public final String encrypt(final String stringParameter, final int keyParameter)
    {
        return CaesarCipherCryptor.encrypt(stringParameter, keyParameter);
    }

    public final String decrypt(final String stringParameter, final int keyParameter)
    {
        return CaesarCipherCryptor.decrypt(stringParameter, keyParameter);
    }

    public final String bruteForceAttack(final String stringParameter)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        for(int key = 0; key <= CaesarCipherCryptor.getMaxKey(); key++)
        {
            stringBuilder.append("Key: ");
            stringBuilder.append(key);
            stringBuilder.append("\n\n");
            stringBuilder.append(CaesarCipherCryptor.decrypt(stringParameter, key));
            stringBuilder.append("\n\n\n\n");
        }
        return stringBuilder.toString();
    }
}
