int strStr(char* haystack, char* needle) {
    if (haystack == NULL || needle == NULL) {
        return -1;
    } 
    

    
    int lenH = strlen(haystack);
    int lenN = strlen(needle);

    if (lenN == 0) {
        return 0;
    }
    
    char* tH = haystack;
    char* tN = needle;
    
    for (int i = 0; i < lenH - lenN + 1; i++) {
        
        for (int j = 0; j < lenN; j++) {
            if (*(tH+j) != *tN) {
                break;
            } else if (j == lenN -1) {
                return i;
            }
            tN++;
            
        }
        
        tH++;
        tN = needle;
    }
    return -1;
}
