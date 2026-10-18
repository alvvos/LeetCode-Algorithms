/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i=digitsSize-1;
    if(*(digits+(digitsSize-1))!=9){
        *(digits+(digitsSize-1))+=1;
        *returnSize=digitsSize;
    } else {
        while(*(digits+i)==9){
            *(digits+i)=0;
            if(i==0){
                *returnSize=digitsSize+1;
                digits=calloc(digitsSize+1, sizeof(int));
                digits[0]=1;
                return digits;
            } else {
                i--;
            }
        }
        *returnSize=digitsSize; 
        *(digits+i)+=1;
    }
    return digits;
}
