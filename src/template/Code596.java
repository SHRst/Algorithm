//http://codeforces.com/contest/596/problem/C
#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<string.h>
        #include<algorithm>
using namespace std;
        #define maxn 150000

        struct node{
        int x,y,w;
        }a[maxn];

        struct weight{
        int pos,val;
        }ww[maxn];


        int cmp(node x,node y){
        if(x.w!=y.w)
        return x.w<y.w;
        if(x.x!=y.x)
        return x.x<y.x;
        return x.y<y.y;
        }

        int cmp2(weight x,weight y){
        if(x.val!=y.val)
        return x.val<y.val;
        return x.pos<y.pos;
        }

        int ans[maxn][2];
        int main()
        {
        int n;
        // freopen("in.txt","r",stdin);
        while(scanf("%d",&n)!=EOF)
        {
        for(int i=0;i<n;i++)
        {
        scanf("%d%d",&a[i].x,&a[i].y);
        a[i].w=a[i].y-a[i].x;
        }
        sort(a,a+n,cmp);
        for(int i=0;i<n;i++)
        {
        scanf("%d",&ww[i].val);
        ww[i].pos=i;
        }

        sort(ww,ww+n,cmp2);
        // for(int i=0;i<n;i++)
        // 	cout<<a[i].x<<" "<<a[i].y<<" "<<a[i].w<<" "<<ww[i].val<<" "<<ww[i].pos<<endl;
        int flag=0;
        for(int i=0;i<n;i++){
        if(a[i].w!=ww[i].val){

        flag=1;
        break;
        }
        ans[ww[i].pos][0]=a[i].x;
        ans[ww[i].pos][1]=a[i].y;
        }
        // for(int i=0;i<n;i++){
        // 	cout<<ans[i][0]<<" "<<ans[i][1]<<endl;
        // }
        // cout<<flag<<endl;
        if(!flag){
        for(int i=0;i<n-1;i++){
        if(ans[i][0]>=ans[i+1][0]&&ans[i][1]>=ans[i+1][1]){
        // cout<<i<<"  de"<<endl;
        flag=1;
        break;
        }
        }
        }
        if(flag)
        puts("NO");
        else{
        printf("YES\n");
        for(int i=0;i<n;i++)
        {
        printf("%d %d\n",ans[i][0],ans[i][1]);
        }

        }
        }
        return 0;
        }