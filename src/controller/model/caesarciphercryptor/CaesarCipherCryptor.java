package controller.model.caesarciphercryptor;

import controller.model.caesarciphercryptor.alphabet.Alphabet;

public final class CaesarCipherCryptor 
{
    private CaesarCipherCryptor()
    {

    }

    public static final String encrypt(final String stringParameter, final int keyParameter)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        final char[] letters = stringParameter.toCharArray();
        for(int i = 0; i < letters.length; i++)
        {
            final char letter =  Character.toUpperCase(letters[i]);
            final Integer letterIndex = Alphabet.getindexByLetter(letter);
            if(letterIndex != null)
            {
                final int newLetterIndex = (letterIndex + keyParameter) % Alphabet.getLength();
                if(newLetterIndex < 0)
                {
                    stringBuilder.append(Alphabet.getLetterByIndex(Alphabet.getLength() + newLetterIndex));
                }
                else
                {
                    stringBuilder.append(Alphabet.getLetterByIndex(newLetterIndex));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final String decrypt(final String stringParameter, final int keyParameter)
    {
        return CaesarCipherCryptor.encrypt(stringParameter, -keyParameter);
    }

    public static final int getMaxKey()
    {
        return Alphabet.getLength() - 1;
    }
}
