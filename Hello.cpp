#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <stdio.h>
using namespace std;
#define int long long
#define deb(x) cout << #x << " " << x << endl;
int MOD = 1000000007;
void solve(){
	int n;
	cin >> n;
	vector<int> v(n,0);
	int xor = 0;
	for(int &x:v){
		cin >> x;
		xor ^= x;
	}
	if(xor==0){
		cout <<"0\n";
		return;
	}
	int parity=0;
	for(int bit=0;bit<64;bit++){
		if(xor&(1<<bit)){
			parity++;
		}
	}
	if(parity&1){
		cout <<"-1\n";
	}
	else{
		int x=0;
		int flip=0;
		for(int bit=0;bit<64;bit++){
			
		}
	}
}

signed main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int t;
	cin >> t;
	while(t--){
		solve();
	}
	return 0;
}