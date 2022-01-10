void main()  
{  
  int i, n; 
  int u[1022], 
 
  u[0] = 1;  
  u[1] = 1;  
  n = 1022; 
 
  for (i = 2 ; i < n ; i++)  
  { 
u[i] = u[i-2] + u[i-1];  
  } 
 }