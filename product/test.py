for i in range(1, 360):

    s = str(360 / i)

    if s.split(".")[1] == "0":

        print(f"{i} = {360 / i}")