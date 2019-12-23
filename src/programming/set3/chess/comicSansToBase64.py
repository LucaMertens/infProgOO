import base64

def generate_java(comic_base64):
    array_string = ''
    n = 65534
    for i in range(0, len(comic_base64), n):
        array_string += ('"' + comic_base64[i:i+n] + '",')
    array_string = array_string[:-1]
    
    return f'''
public static final String[] SANS_ARRAY = {{{array_string}}};
public static Font fontToUse;

static {{
        // Assemble the base64 string.
        StringBuilder bob = new StringBuilder();
        for (String str : SANS_ARRAY) {{
            bob.append(str);
        }}

        // Decode the base64 string to binary.
        byte[] comicBytes = java.util.Base64.getDecoder().decode(bob.toString());
        // Create an inputStream for the font.
        try {{
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(comicBytes);
            // Create comic sans as a font and set its size to 24.
            fontToUse = Font.createFont(Font.TRUETYPE_FONT, in).deriveFont(Font.BOLD, 24f);

        }} catch (Exception e) {{
            // If comic-sans isn't available, fall back to the default font.
            fontToUse = GLabel.DEFAULT_FONT;
        }}
    }}'''

with open('C:\\comic.ttf', 'rb') as f:
    comic_bytes = f.read()
    comic_base64 = base64.b64encode(comic_bytes).decode('utf8')
    print(generate_java(comic_base64))
