package com.targetsmile.dentalcare;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by veetrag on 06/02/16.
 */

final class Data {

    static final String[] URLS = {
            "http://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xpa1/v/t1.0-9/12341573_1629758050618678_2244804782550910763_n.png?oh=e2f746c7c4e011ab86326528b5919602&oe=57364E1B",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xat1/v/t1.0-9/12341084_1630078827253267_4741718670284840894_n.png?oh=a7f0fc48b02719282ac4570b16de9a87&oe=573A99FA",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xpf1/v/t1.0-9/12345406_1630345123893304_8781666207783142036_n.png?oh=a69e93260488420bf0096ba48eb02f09&oe=5737BF93",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xtf1/v/t1.0-9/1012038_1631416000452883_5622843446841075987_n.png?oh=d6cdc35c48f8f1b494bf8a60e009a08f&oe=5726D2DA",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xfl1/v/t1.0-9/530510_1633621616898988_7840696357310040453_n.png?oh=5cd39e208be226b625b5bc76cf6c52f4&oe=57332202",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xft1/v/t1.0-9/1935243_1634173986843751_638047955971333364_n.png?oh=7788fe85c3aa904cf9affe02f0533a14&oe=573B14F9",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xlt1/v/t1.0-9/1935771_1636458473281969_4361763660528385818_n.png?oh=9f764f970869d2ff2329ec3b9673c6a6&oe=574000D9",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xta1/v/t1.0-9/12494744_1639646279629855_1060939186909670790_n.png?oh=bb32a2067b4707ec4c20d9cea0175676&oe=5735E275",
            "https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xlf1/v/t1.0-9/12376388_1642660829328400_1799892353056958793_n.png?oh=2d68f813c80e045809f946c7ca39a74d&oe=57283C7F",
            "https://scontent-sin1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/61579_1644492529145230_867043287643108450_n.png?oh=886f6d28510ef686e9f3efcaf00c39e2&oe=57321953",
            "https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xtp1/v/t1.0-9/12573158_1643220969272386_2448989607178117098_n.png?oh=9d9828f6e2120e8e372c583618928463&oe=5722BA1D&__gda__=1466422075_009487c1421f96f02d2c3a85343d2956",
    };






    public static Set<String> fetchData()
    {
        Set<String> defaultDentalFactsURL = new HashSet<String>();

        defaultDentalFactsURL.add("http://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xpa1/v/t1.0-9/12341573_1629758050618678_2244804782550910763_n.png?oh=e2f746c7c4e011ab86326528b5919602&oe=57364E1B");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xat1/v/t1.0-9/12341084_1630078827253267_4741718670284840894_n.png?oh=a7f0fc48b02719282ac4570b16de9a87&oe=573A99FA");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xpf1/v/t1.0-9/12345406_1630345123893304_8781666207783142036_n.png?oh=a69e93260488420bf0096ba48eb02f09&oe=5737BF93");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xtf1/v/t1.0-9/1012038_1631416000452883_5622843446841075987_n.png?oh=d6cdc35c48f8f1b494bf8a60e009a08f&oe=5726D2DA");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xfl1/v/t1.0-9/530510_1633621616898988_7840696357310040453_n.png?oh=5cd39e208be226b625b5bc76cf6c52f4&oe=57332202");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xft1/v/t1.0-9/1935243_1634173986843751_638047955971333364_n.png?oh=7788fe85c3aa904cf9affe02f0533a14&oe=573B14F9");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xlt1/v/t1.0-9/1935771_1636458473281969_4361763660528385818_n.png?oh=9f764f970869d2ff2329ec3b9673c6a6&oe=574000D9");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xta1/v/t1.0-9/12494744_1639646279629855_1060939186909670790_n.png?oh=bb32a2067b4707ec4c20d9cea0175676&oe=5735E275");
        defaultDentalFactsURL.add("https://scontent.fmaa1-2.fna.fbcdn.net/hphotos-xlf1/v/t1.0-9/12376388_1642660829328400_1799892353056958793_n.png?oh=2d68f813c80e045809f946c7ca39a74d&oe=57283C7F");
        defaultDentalFactsURL.add("https://scontent-sin1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/61579_1644492529145230_867043287643108450_n.png?oh=886f6d28510ef686e9f3efcaf00c39e2&oe=57321953");
        defaultDentalFactsURL.add("https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xtp1/v/t1.0-9/12573158_1643220969272386_2448989607178117098_n.png?oh=9d9828f6e2120e8e372c583618928463&oe=5722BA1D&__gda__=1466422075_009487c1421f96f02d2c3a85343d2956");

        return defaultDentalFactsURL;
    }
}