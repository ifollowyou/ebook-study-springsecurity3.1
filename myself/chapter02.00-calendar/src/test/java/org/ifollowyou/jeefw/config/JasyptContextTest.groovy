package org.ifollowyou.jeefw.config


class JasyptContextTest {

    public static void main(String[] args) {
        JasyptContext context = new JasyptContext()
        String toEncrypt = 'jeefw'
        if (args.length == 1) {
            toEncrypt = args[0]
        }

        println 'Encrypted info:'
        println context.getEncryptMessage(toEncrypt)
    }
}
