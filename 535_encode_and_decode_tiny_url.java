/*
    Use base62 to convert long url to short url
*/
public class Codec {
    int counter;
    String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, Integer> long2short;
    Map<Integer, String> short2long;
    String prefix;

    public Codec() {
        this.long2short = new HashMap<>();
        this.short2long = new HashMap<>();
        this.counter = 1;
        this.prefix = "http://tiny.url/";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = base10ToBase62(counter);
        long2short.put(longUrl, counter);
        short2long.put(counter, longUrl);
        ++counter;
        return this.prefix + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String body = shortUrl.substring(this.prefix.length());
        int n = base62ToBase10(body);
        return short2long.get(n);
    }

    int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;
    }

    int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }

    String base10ToBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() != 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
