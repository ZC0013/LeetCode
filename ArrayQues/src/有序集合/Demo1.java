package 有序集合;

/**
 * @Created by zhang on 2021/8/14  17:03
 */
public class Demo1 {

    /**
     * #include <bits/stdc++.h>
     * using namespace std;
     * int main() {
     *     ios_base::sync_with_stdio(false), cin.tie(nullptr);
     *     int n, x;
     *     long long ans = 0;
     *     set<int> S;
     *     cin >> n;
     *     for (int i = 1; i <= n; ++i) {
     *         cin >> x;
     *         auto it = S.lower_bound(x);
     *         if (it != S.begin()) {
     *             --it;
     *             ans += 1LL * i * (*it);
     *         }
     *         S.emplace(x);
     *     }
     *     cout << ans << '\n';
     *     return 0;
     * }
     * @param args
     */
    public static void main(String[] args) {


    }
}
