package controller.model.caesarciphercryptor.alphabet;

public final class Alphabet 
{
    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private Alphabet()
    {

    }

    public static final int getLength()
    {
        return Alphabet.alphabet.length;
    }

    public static final char getLetterByIndex(final int indexParameter)
    {
        return Alphabet.alphabet[indexParameter];
    }

    public static final Integer getindexByLetter(final char letterParameter) 
    {
        for(int i = 0; i < Alphabet.alphabet.length; i++)
        {
            if(letterParameter == Alphabet.alphabet[i])
            {
                return i;
            }
        }
        return null;
    }
}
