class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        bulls = 0
        secret_count = dict() # {key => count}
        guess_count = dict()
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
            else:
                s_count = secret_count.setdefault(secret[i], 0)
                s_count += 1
                secret_count[secret[i]] = s_count

                g_count = guess_count.setdefault(guess[i], 0)
                g_count += 1
                guess_count[guess[i]] = g_count

        cows = 0
        for s_key, s_val in secret_count.items():
            if s_key in guess_count:
                cows += min(s_val, guess_count[s_key])
        return "{0}A{1}B".format(bulls, cows)


