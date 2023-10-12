/**
*Input : original_time = "10:10:10", 
*             new_time = "05:02:58" 
*Output : 24
*Operations = 5 + 7 + 12 = 24   
*
*Input : original_time = "13:12:21", 
*             new_time = "11:10:18"
*Output : 7
*Operations = 2 + 2 + 3 = 7
**/

public solution {

  public int getOperations(String originalTime, String newTime) {
    String[] originalTimeStrs = originalTime.split(":");
    String[] newTimeStrs = newTime.split(":");
    int h_oper = calcMinOperation(Integer.parseInt(originalTimeStrs[0]), Integer.parseInt(newTimeStrs[0]), 12);
    int m_oper = calcMinOperation(Integer.parseInt(originalTimeStrs[1]), Integer.parseInt(newTimeStrs[1]), 60);
    int s_oper = calcMinOperation(Integer.parseInt(originalTimeStrs[2]), Integer.parseInt(newTimeStrs[2]), 60);
    return h_oper + m_oper + s_oper;
  }

  private Integer calcMinOperation(int a, int b, int max) {
    int abDif = Math.abs(a-b);
    if (abDif > max / 2) {
        return max - abDiff;  
    } else {
      return abDiff;
    }
  }
}
