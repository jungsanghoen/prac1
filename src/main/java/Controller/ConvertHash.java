package Controller;

import dto.RequestDto;
import service.HashService;

public class ConvertHash {
    private HashService hashService = new HashService();

    /*
    * 메인 함수
    * 새로운 패스워드 추가
    * 새로운 hash, salt값 추가
     */
    public void InsertNewPasswd()
    {
        RequestDto requestDto = RequestDto.builder()
                .hashid(1)
                .salt("없는 각")
                .build();

    }

    @Override
    public String toString() {
        return "ConvertHash{" +
                "hashService=" + hashService +
                '}';
    }

    public static void main(String[] args)
    {
        ConvertHash convertHash = new ConvertHash();
        System.out.println(convertHash.toString());
    }
}
