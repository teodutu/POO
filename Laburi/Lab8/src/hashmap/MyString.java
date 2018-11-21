package hashmap;

public class MyString implements Comparable<MyString> {
    private String str;

    MyString(String newStr) {
        str = newStr;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        int len = str.length();

        for (int i = 0; i < len; ++i) {
            hashCode += str.charAt(i) * 31;
        }

        return hashCode;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public int compareTo(MyString myString) {
        return str.compareTo(myString.str);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyString) {
            return str.equals(((MyString)obj).str);
        }

        return false;
    }
}
