package name.guolanren;

import com.baomidou.dynamic.datasource.toolkit.CryptoUtils;

/**
 * @author guolanren
 */
public class Encode {

    public static void main(String[] args) throws Exception {
        String originalUsername = "guolanren";
        String originalPassword = "123456";

        //自定义publicKey
        String[] arr = CryptoUtils.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("encodeUsername:" + CryptoUtils.encrypt(arr[0], originalUsername));
        System.out.println("encodePassword:" + CryptoUtils.encrypt(arr[0], originalPassword));
    }

}
