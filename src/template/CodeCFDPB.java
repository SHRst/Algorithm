// 所以这不是DP,是树状数组。。。

#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<string.h>
        #include<algorithm>
using namespace std;
        #define maxn 110

        int n,m;
        int a[maxn];
        double dp[maxn][maxn];
        double dp1[maxn][maxn];
        double ans;

        int main(){
        // freopen("in.txt","r",stdin);
        while(scanf("%d%d",&n,&m)!=EOF){
        for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
        }
        double p = n*(n+1)*0.5;
        p = 1.0/p;
        memset(dp,0,sizeof(dp));
        for(int i=0;i<n;i++)
        for(int j=i+1;j<n;j++)
        dp[i][j]=1.0;
        // cout<<p<<endl;
        while(m--){
        memcpy(dp1,dp,sizeof(dp));
        memset(dp,0,sizeof(dp));
        for(int l=0;l<n;l++){
        for(int r =l;r<n;r++){
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        int a=i;
        int b=j;
        // 翻转l,r对i,j区间的影响

        if(a>=l && a<=r) a=l+r-a;
        if(b>=l && b<=r) b=l+r-b;
        if(a>b)	swap(a,b);
        if(l<=i && r>=j) dp[a][b]+=p*(1-dp1[i][j]);
        else dp[a][b]+=p*(dp1[i][j]);
        // cout<<l<<" "<<r<<" "<<i<<" "<<j<<" "<<a<<" "<<b<<" "<<dp[a][b]<<endl;
        }
        }
        }
        }
        }
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
        if(a[i]>a[j]){
        ans+=dp[i][j];
        }else{
        ans+=1-dp[i][j];
        }
        }
        }
        printf("%.10f\n",ans);
        }
        return 0;
        }