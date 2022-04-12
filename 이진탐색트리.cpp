#include<iostream>

using namespace std;

typedef struct _TreeNode {      // 트리 정의
    int key;    
    _TreeNode* left;    
    _TreeNode* right;   
}TreeNode;



// 1: 검색
TreeNode* searchTree(TreeNode* root, int key) {
    if (root == NULL) {         
        cout << "찾는 키 값 [" << key << "] 는 트리에 없습니다.\n";
        return NULL;
    }

    if (key == root->key) {     
        cout << "찾는 키 값 [" << key << "] 는 트리에 있습니다.\n";
        return root;
    }
    else if (key < root->key) {    // 키값이 노드보다 작은 경우 왼쪽 서브트리 탐색 
        searchTree(root->left, key);
    }
    else if (key > root->key) {    // 키값이 노드보다 큰 경우 오른쪽 서브트리 탐색 
        searchTree(root->right, key);
    }

}



// 2 : 삽입
TreeNode* insertNode(TreeNode* root, int key) {
    TreeNode* pointer;                                          
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode));    
    newNode->key = key;
    newNode->left = newNode->right = NULL;

    if (root == NULL) {                 // 트리가 비어 있을 경우 
        root = newNode;
        return root;
    }

    pointer = root;                    

    while (pointer) {
        if (key == pointer->key) {    // 이미 존재하는 값일 때
            cout << "이미 존재하는 값입니다.\n";
            return root;
        }
        else if (key < pointer->key) {       // 왼쪽 서브트리 
            if (pointer->left == NULL) {
                pointer->left = newNode;
                return root;
            }
            else {                     // 비어있지 않다면 다시 탐색 진행 
                pointer = pointer->left;
            }
        }
        else {                              // 오른쪽 서브트리 
            if (pointer->right == NULL) {
                pointer->right = newNode;
                return root;
            }
            else {                     // 비어있지 않다면 다시 탐색 진행 
                pointer = pointer->right;
            }
        }
    }

}



// 3 : 삭제
TreeNode* deleteNode(TreeNode* root, int key) {
    TreeNode* delNode = NULL;           // 삭제할 노드     
    TreeNode* parent = NULL;        // 삭제할 노드의 부모 노드 
    TreeNode* leftMax = NULL;       // 삭제할 노드의 왼쪽 서브트리에서 가장 큰 노드 
    TreeNode* preLeftMax = NULL;    // leftMax의 부모노드 
    TreeNode* child = NULL;         // 삭제할 노드의 자식 노드 

    delNode = root;
    while (delNode != NULL) {           // 삭제할 노드 탐색 
        if (key == delNode->key) {
            break;
        }
        parent = delNode;
        if (key < delNode->key) {
            delNode = delNode->left;
        }
        else {
            delNode = delNode->right;
        }
    }

    if (delNode == NULL) {
        cout << "삭제할 키 값 [" << key << "]은 트리에 없습니다.";
        return root;
    }

    if (delNode->left == NULL && delNode->right == NULL) {  // 삭제할 노드의 자식노드가 없는 경우 
        if (parent != NULL) {                       // 부모노드가 있는 경우 
            if (parent->left == delNode) {
                parent->left = NULL;
            }
            else {    
                parent->right = NULL;
            }
        }
        else {                                      // 부모노드가 없는 경우
            root = NULL;
        }
    }
    else if (delNode->left != NULL && delNode->right != NULL) {    // 삭제할 노드의 자식 노드 2개일 때
        preLeftMax = delNode;
        leftMax = delNode->left;

        while (leftMax->right != NULL) {           // 왼쪽 서브트리에서 가장 큰 값 찾기 
            preLeftMax = leftMax;
            leftMax = leftMax->right;
        }

        preLeftMax->right = leftMax->left;
        leftMax->left = delNode->left;
        leftMax->right = delNode->right;

        if (parent != NULL) {                       // 삭제할 노드의 부모노드가 있을 때 
            if (parent->left == delNode) {
                parent->left = leftMax;
            }
            else {
                parent->right = leftMax;
            }
        }
        else {
            root = leftMax;
        }
    }
    else {                                          // 삭제할 노드의 자식 노드가 1개일 때
        if (delNode->left != NULL) {
            child = delNode->left;
        }
        else {    
            child = delNode->right;
        }

        if (parent != NULL) {                       // 부모노드가 있는 경우 
            if (parent->left == delNode) {
                parent->left = child;
            }
            else {    
                parent->right = child;
            }
        }
        else {
            root = child;
        }
    }

    free(delNode);
    return root;
}



// 4 : 출력
void printTree(TreeNode* root) {
    if (root == NULL) {
        return;
    }
    cout << root->key << " ";

    printTree(root->left);
    printTree(root->right);
}



int main() {
    TreeNode* root = NULL;
    TreeNode* ptr = NULL;

    while (true) {
        int menu;
        int a;
        cout << "0 : 종료\n1 : 검색\n2 : 삽입\n3 : 삭제\n4: 출력\n메뉴를 선택하세요 : ";
        cin >> menu;
        if (menu == 0) {
            break;
        }
        else if (menu == 1) {
            cout << "검색할 키 값을 입력하세요 : ";
            cin >> a;
            ptr = searchTree(root, a);
            cout << "\n";
        }
        else if (menu == 2) {
            cout << "삽입할 키 값을 입력하세요 : ";
            cin >> a;
            root = insertNode(root, a);
            cout << "\n";
        }
        else if (menu == 3) {
            cout << "삭제할 키 값을 입력하세요 : ";
            cin >> a;
            root = deleteNode(root, a);
            cout << "\n";
        }
        else if (menu == 4) {
            cout << "출력 결과 >> ";
            printTree(root);
            cout << "\n";
        }
    }
    
    return 0;
}
