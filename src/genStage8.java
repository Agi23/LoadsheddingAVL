class genStage8{
    public static void main(String[] args) {
        LSArray Data = new LSArray(true);
        LSInfoItem[] arrTotalItems = Data.getArray();
        String[] arrStage8;
        int count =0;
        String line;
        int stage;
        int pos;
        int day;

        for (LSInfoItem p : arrTotalItems){
            line = p.getLSRawString();
            stage = Character.getNumericValue(line.charAt(0));
            pos = line.lastIndexOf("_");
            day = Integer.parseInt(line.substring(2, pos));

            if ((stage == 8)&& (day <= 16) &&(day%4==0)){
                System.out.println(line);
                count++;
            }
        }
        System.out.println(count);


    }
}