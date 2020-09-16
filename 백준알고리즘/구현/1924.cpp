#include <iostream>
#include <string>
using namespace std;

int main(void){
	int year = 2007;
	int m, d;
	string DOW[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	
	cin >> m;
	cin >> d;
	
	if(m<3){
		m = m+12;
		year = year-1;
	} 
	
	int a = year/100;
	int b = year%100;
	
	int dayOfWeek = ((21 * a / 4) + (5 * b / 4) + (26 * (m + 1) / 10) + d - 1) % 7;
	
	cout << DOW[dayOfWeek] << endl;
	return 0;
}
