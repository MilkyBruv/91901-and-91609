with open("README.md", "r") as file:

    lines = file.readlines()

for line in lines:

    if "#" in line:

        line = line.replace("\n", "")

        link = line.replace("# ", "")
        link = link.replace("#", "")
        link = link.replace(" ", "-")
        link = link.lower()

        text = line.replace("# ", "")
        text = text.replace("#", "")

        l = f"[{text}](#{link})\n"

        print(l)