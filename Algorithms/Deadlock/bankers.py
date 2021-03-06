import string
import numpy as np
import pandas as pd

def checkIfValidRes(resources, maxReq):
    for i in range(len(resources)):
        if resources[i] < maxReq[i]:
            return False
    return True

# Will only work with numpy arrays
def printMatrix(matrix):

    # For single dimension matrix
    if matrix.ndim < 2:
        matrix = [matrix]
        processIndex = None
        cols = tuple(string.ascii_uppercase[:len(matrix[0])])
        print(pd.DataFrame(matrix, index=("R",), columns=cols))
        return

    # For multi dimesional matrix
    processIndex = [f"P{x+1}" for x in range(len(matrix))]
    cols = tuple(string.ascii_uppercase[:len(matrix[0])])
    print(pd.DataFrame(matrix, index=processIndex, columns=cols))

def printSafeState(state):
    print(" -> ".join(state))

def bankersSkel(alloc, maxReq, totalRes=None, availRes=None):
    avail = []

    if availRes is None:
        # Available = Total Resources - Sum of each column in alloc
        avail = totalRes - np.sum(alloc, axis=0)
        if np.any(avail < 0):
            print("Insufficient resources to allocate to processes")
            return
    elif totalRes is None:
        avail = availRes
    else:
        print("Either provide total resources or available resources")
        return

    # Need = Max - Allocation
    need = maxReq - alloc

    # Printing all matrices
    print(f"\n< Allocation Matrix >")
    printMatrix(alloc)
    print(f"\n< Max Matrix (Claim) >")
    printMatrix(maxReq)
    print(f"\n< Need Matrix >")
    printMatrix(need)
    print(f"\n< Available Matrix >")
    printMatrix(avail)

    # Flags for knowing which process is completed
    flags = [0 for y in range(len(need))]

    # Storing safeState
    safeState = []

    # Index of process
    i = 0

    while len(safeState) != len(need):

        if flags[i] == 0 and checkIfValidRes(avail, need[i]):
                # Set as found
                flags[i] = 1

                # Provide process resources
                prevAvail = avail
                avail = avail - need[i]

                # Release resouces
                avail = avail + maxReq[i]

                # Start from 0
                i = -1

        i += 1

    printSafeState(safeState)

    printMatrix(avail)


def bankers(alloc, maxReq, totalRes=None, availRes=None):

    avail = []

    if availRes is None:
        # Available = Total Resources - Sum of each column in alloc
        avail = totalRes - np.sum(alloc, axis=0)
        if np.any(avail < 0):
            print("Insufficient resources to allocate to processes")
            return
    elif totalRes is None:
        avail = availRes
    else:
        print("Either provide total resources or available resources")
        return

    # Need = Max - Allocation
    need = maxReq - alloc

    # Printing all matrices
    print(f"\n< Allocation Matrix >")
    printMatrix(alloc)
    print(f"\n< Max Matrix (Claim) >")
    printMatrix(maxReq)
    print(f"\n< Need Matrix >")
    printMatrix(need)
    print(f"\n< Available Matrix >")
    printMatrix(avail)

    # Flags for knowing which process is completed
    flags = [0 for y in range(len(need))]

    # Storing safeState
    safeState = []

    # Index of process
    i = 0

    print("\n=== Start ===")

    while len(safeState) != len(need):

        if flags[i] == 0:
            print(f"P{i}'s Need \t\t:{need[i]}")
            print(f"Resources \t\t:{avail}")

            if checkIfValidRes(avail, need[i]):
                print(f"Enough resources to allocate for P{i}")
                # Set as found
                flags[i] = 1

                safeState.append(f"P{i}")

                # Provide process resources
                tempAvail = avail
                avail = avail - need[i]
                print(f"Available \t\t:{tempAvail} - {need[i]} = {avail}")

                # Print total resources taken
                print(f"Total Resources of P{i} \t:{alloc[i]} + {need[i]} = {maxReq[i]}")

                print(f"Process completed execution. Releasing Resources ...")

                # Release resouces
                tempAvail = avail
                avail = avail + maxReq[i]

                # Print total resources taken
                print(f"Available \t\t:{maxReq[i]} + {tempAvail} = {avail}")

                # Print Safe State
                print("Safe State \t\t:", end="")
                printSafeState(safeState)

                # Start from 0
                i = -1

            else:
                print(f"Not enough resources to allocate for P{i}")

            print()
        i += 1

    print("=== End ===")

    printSafeState(safeState)

    printMatrix(avail)

def inputMatrix(rows, cols):
    if rows < 1 or cols < 1:
        print("Invalid Matrix Size")
        return

    mat = np.empty((rows, cols), dtype=int)

    if rows > 1:
        for i in range(rows):
            print(f" ==> P{i}")

            for j in range(cols):
                mat[i][j] = int(input(f"  -> R{j} : "))

            print()
    else:
        mat = np.empty(cols, dtype=int)
        for j in range(cols):
            mat[j] = int(input(f"  -> R{j} : "))

    return mat

if __name__ == "__main__":

    # numRes = int(input("Enter number of resources : "))
    # numProcess = int(input("Enter number of processes : "))

    # print("Enter Data for Allocation Matrix : ")
    # allocationMatrix = inputMatrix(numProcess, numRes)

    # print("Enter Data for Max Matrix : ")
    # maxMatrix = inputMatrix(numProcess, numRes)

    # print("Enter Data for Available Resources Vector : ")
    # availResources = inputMatrix(1, numRes)

    allocationMatrix = np.array([
        [ 0, 0, 1, 2 ],
        [ 1, 0, 0, 0 ],
        [ 1, 3, 5, 4 ],
        [ 0, 6, 3, 2 ],
        [ 0, 0, 1, 4 ]
    ])

    maxMatrix = np.array([
        [ 0, 0, 1, 2 ],
        [ 1, 7, 5, 0 ],
        [ 2, 3, 5, 6 ],
        [ 0, 6, 5, 2 ],
        [ 0, 6, 5, 6 ]
    ])

    # Prints each step in detail

    # Example with total resources
    # totalResources = np.array([28, 15, 13])
    # bankers(allocationMatrix, maxMatrix, totalRes=totalResources)

    # Example with available resources
    availResources = np.array([1, 5, 2, 0])
    bankers(allocationMatrix, maxMatrix, availRes=availResources)

    # Prints final answer
    # bankersSkel(allocationMatrix, maxMatrix, totalResources)
